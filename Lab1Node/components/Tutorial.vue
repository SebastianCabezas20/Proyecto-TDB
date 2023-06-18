<template>


<body> 
    

 <div class="general">
        <h1>Crear una nueva Tarea</h1>
        <input type="" id="nombreTarea" v-model="nombreTarea" placeholder = "Nombre Tarea">
        <input type="text" id="Descripcion" v-model="Descripcion" placeholder = "Descripcion">
        <input type="number" id="NumeroVoluntarios" v-model="NumeroVoluntarios" placeholder = "Cantidad de voluntarios">
    <div class="row">
        <div class="column" >
        <h2>Escoja una emergencia:</h2>
        <select v-model="id_emergencia">
            <option v-for="(item3, index3) in items3" :key="index3" id="emergencia" :value = item3.id >{{item3.nombre}}</option>
        </select>
        </div>

      {{point}}

      </div>
      <br><br>
      <button @click="sendTarea()" type="Reset">Ingresar nueva tarea</button>
      <div>
      <div id="mapid"></div>
      </div>
      <br><br><br><br>
 </div>

    <div class="general">
        <h1>Crear una nueva Emergencia</h1>
        <input type="" id="nombre" v-model="nombre" placeholder = "Nombre Emergencia">
  <div class="row">
    <div class="column" >
      <h2>Escoja una institución:</h2>
      <select v-model="id_institucion">
        <option v-for="(item2, index2) in items2" :key="index2" id="institucion" :value = item2.id >{{item2.nombre}}</option>
      </select>
    </div>

      {{point}}

  <div class="column">
    <h2>Escoja habilidades:</h2>
      <div v-for="(item, index) in items" :key="index">
        <input type="checkbox" :value = item.id v-model="habilidades">{{item.nombre}}
        <br>
      </div>
  </div>
  </div>
  <br><br>
  <button @click="send()" type="Reset">Ingresar emergencia</button>
  
  <br>
    </div>
    <h1>Buscador de emergencia</h1>
    <Buscador/>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    
</body>



</template>



<script>
import 'leaflet/dist/leaflet'; //librería leaflet
import 'leaflet/dist/leaflet.css'; //css leaflet

export default {
    //Función que contiene los datos del componente
    data:function(){
        return{
            //Lista de ítems a mostrar
            items:[],
            items2:[],
            items3:[],
            latitude:null, //Datos de nuevo punto
            longitude:null,
            nombre:"",
            id_institucion :null,
            habilidades: [],
            //// DATA TAREA
            nombreTarea:"",
            Descripcion:"",
            NumeroVoluntarios:null,
            id_emergencia :null,
            newPeticion:{}
        }
        
    },
    computed:{
    point(){ // función computada para representar el punto seleccionado
      if(this.latitude && this.longitude){
        let lat = this.latitude.toFixed(3);
        let lon = this.longitude.toFixed(3);
        return `(${lat}, ${lon})`;
      }else{
        return '';
      }
    }
  },
    methods:{
        vaciar(){
              this.nombre="";
              this.id_institucion = null;
              this.latitude = null, //Datos de nuevo punto
              this.longitude = null,
              this.habilidades = [];
        },
        vaciarTarea(){
              ///// DATA PARA TAREA
              this.nombreTarea="";
              this.Descripcion="";
              this.NumeroVoluntarios=null;
              this.id_emergencia =null;
              this.latitude = null; //Datos de nuevo punto
              this.longitude = null;
        },
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response = await this.$axios.get('/Habilidades');
                this.items  = response.data;
                console.log(response)
            } catch (error) {
                console.log('error', error);
            }
        },
        getData2: async function(){
            try {
                let response = await this.$axios.get('/Instituciones');
                this.items2  = response.data;
                console.log(response)
            } catch (error) {
                console.log('error', error);
            }
        },
        getData3: async function(){
            try {
                let response = await this.$axios.get('/Emergencias');
                this.items3  = response.data;
                console.log(response)
            } catch (error) {
                console.log('error', error);
            }
        },
        send: async function(){
          try {
              if(document.getElementById("nombre").value == ""){
                alert("Falta el nombre de la emergencia");

                return 0;
                
              }
             
              if(this.id_institucion == null){
                alert("Falta seleccionar la institucion");

                return 0;

              }
              if(this.habilidades.length == 0){
                alert("Falta seleccionar habilidades");

                return 0;
              }
              if(this.latitude == null || this.longitude == null){
                alert("Falta agregar una ubicacion");

                return 0;
              }

              let emergencia ={
              nombre: this.nombre,
              latitude: this.latitude,
              longitude: this.longitude,
              estado:"creada",
              id_institucion:this.id_institucion
              } 

              var result = await this.$axios.post('/Create/Emergencia',emergencia);
              let resultado = result.data;
             
              alert("Emergencia creada");
              let id = resultado.id;

              this.newPeticion.id_emergencia = id;


              for (let index = 0; index < this.habilidades.length; index++) {
                this.newPeticion.id_habilidad = this.habilidades[index];
                console.log(this.habilidades[index]);
                await this.$axios.post('/Create/Emergencia_habilidad',this.newPeticion);
              }
              this.vaciar();
              } catch (error) {
              //mensaje de error
              console.log('error', error)
              }
          },
        sendTarea: async function(){
        try {
            if(document.getElementById("nombreTarea").value == ""){
              alert("Falta el nombre de la tarea");

              return 0;
              
            }
            if(document.getElementById("Descripcion").value == ""){
              alert("Falta la descripcion");

              return 0;

            }
            if(this.id_emergencia == null){
              alert("Falta seleccionar una emergencia");

              return 0;

            }
            if(this.NumeroVoluntarios == null || this.NumeroVoluntarios<=0){
                alert("Ingrese un numero valido");
              return 0;
            }
            if(this.latitude == null || this.longitude == null){
              alert("Falta agregar una ubicacion");

              return 0;
            }

            let tarea ={
            nombre: this.nombreTarea,
            descripcion: this.Descripcion,
            cantd_voluntarios: this.NumeroVoluntarios,
            id_eme: this.id_emergencia,
            id_estado_tarea: 1,
            latitude: this.latitude,
            longitude: this.longitude
            } 
          
            var result = await this.$axios.post('/Create/Tarea', tarea);
            let resultado = result.data;
            
            alert("Tarea creada");

            this.vaciarTarea();
            } catch (error) {
            //mensaje de error
            console.log('error', error)
            }
        },
           
    },
    mounted:function(){
    let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
     this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(this.mymap);
    //Evento click obtiene lat y long actual
    this.mymap.on('click', function(e) {
      _this.latitude = e.latlng.lat;
      _this.longitude =e.latlng.lng;
    });
  }, 
  //Función que se ejecuta al cargar el componente
  created:function(){
      this.getData();
      this.getData2();
      this.getData3();
  }
}
</script>



<style>
.row:after{
  content: "";
  display: table;
  clear: both;
}
.column{
  float:left;
  width:50%;
}
.home{
  display:flex;
  flex-direction: column;
  align-items: center;
}
/* Estilos necesarios para definir el objeto de mapa */
#mapid { 
  height: 400px; 
  width:600px;
}
</style>

