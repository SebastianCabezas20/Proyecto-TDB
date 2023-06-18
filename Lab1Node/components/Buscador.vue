<template>
    <div class="contenedor">
        <label for="ID">Seleccione la region de la emergencia</label>
        <select name="ID" id="Region" v-model="id">
            <option value= 5>Región de Valparaíso</option>
            <option value= 6>Región del Libertador Bernardo O''Higgins</option>
            <option value= 10>Región de Los Lagos</option>
            <option value= 3>Región de Atacama</option>
            <option value= 13>Región Metropolitana de Santiago</option>
            <option value= 11>Región de Aysén del Gral.Ibañez del Campo</option>
            <option value= 9>Región de La Araucanía</option>
            <option value= 7>Región del Maule</option>
            <option value= 1>Región de Tarapacá</option>
            <option value= 14>Región de Los Ríos</option>
            <option value= 8>Región del Bío-Bío</option>
            <option value= 2>Región de Antofagasta</option>
            <option value= 15>Región de Arica y Parinacota','Parinacota</option>
            <option value= 4>Región de Coquimbo</option>
            <option value= 12>Región de Magallanes y Antártica Chilena</option>
        </select>
        <button  @click="send()">Revisar</button>
             <ul>
               <li v-for="(item, index) in items" :key="index">{{item}}</li>
            </ul>
    </div>


    
</template>

<script>
export default {
    //Función que contiene los datos del componente
    data:function(){
        return{
            //Lista de ítems a mostrar
            id: null,
            items:[]
        }
        
    },
    methods:{
        send: async function(){
            if(this.id == null){
                alert("Seleccione una region");
                return 0;
            }
            try {
                let response = await this.$axios.get(`/Region/${this.id}`);
                this.items  = response.data;
                console.log(response)
                this.id = null;
                
            } catch (error) {
                console.log('error', error);
            }
        }
    }
}
</script>




