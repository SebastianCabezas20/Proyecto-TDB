<template>


<body> 
    <div class="general">
        <h1>Crear una nueva Tarea</h1>
        <input type="" id="nombre" v-model="nombre" placeholder = "Nombre Tarea">
        <input type="text" id="Descripcion" v-model="Descripcion" placeholder = "Descripcion">
        <input type="number" id="NumeroVoluntarios" v-model="NumeroVoluntarios" placeholder = "Cantidad de voluntarios">
    <div class="row">
        <div class="column" >
        <h2>Escoja una emergencia:</h2>
        <select v-model="id_emergencia">
            <option v-for="(item2, index2) in items2" :key="index2" id="emergencia" :value = item2.id >{{item2.nombre}}</option>
        </select>
        </div>

      {{point}}

  </div>
  <br><br>
  <button @click="send()" type="Reset">Ingresar nueva tarea</button>
  <div>
  <div id="mapid"></div>
  </div>
  <br><br><br><br>
 </div>
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
            nombre:"",
            Descripcion:"",
            NumeroVoluntarios:null,
            id_emergencia :null,
            latitude:null, //Datos de nuevo punto
            longitude:null,
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
            this.Descripcion="";
            this.NumeroVoluntarios=null;
            this.id_emergencia =null;
            this.latitude=null; //Datos de nuevo punto
            this.longitude=null;
        },
        getData2: async function(){
            try {
                let response = await this.$axios.get('/Emergencias');
                this.items2  = response.data;
                console.log(response)
            } catch (error) {
                console.log('error', error);
            }
        },
        send: async function(){
          try {
              if(document.getElementById("nombre").value == ""){
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
              nombre: this.nombre,
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

              this.vaciar();
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
      this.getData2();
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

