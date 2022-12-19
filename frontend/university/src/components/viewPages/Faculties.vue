<template>
  <Header class="header"></Header>
  <h1 class="f_h">Faculties</h1>
  <table>
    <tr v-for="faculty in faculties" v-bind:key="faculty.id">
      <td><router-link :to="`/faculties/${faculty.id}`">{{faculty.shortName}}</router-link></td>
      <td class="edit"><font-awesome-icon class="icon" icon="pen-to-square" /></td>
      <td class="delete"><font-awesome-icon class="icon" icon="trash-can" /></td>
    </tr>
  </table>

  <Footer class="footer"></Footer>

</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import FacultyService from "../../service/FacultyService.js"

export default {
  name: "Faculties",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      faculties:[]
    }
  },
  methods:{
    getFaculties(){
      FacultyService.getFaculties().then((response)=>{
        this.faculties=response.data;
      });
    }
  },
    created(){
    this.getFaculties()
  }
}

</script>

<style scoped>
.header{
  margin-bottom: 60px;
}

.footer{
  position:relative;
  bottom:0;
}

.f_h{
  color: #42424b;
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
  font-family: sans-serif;
}
table{
  display: grid;
  grid-row-gap: 5px;
  width:500px ;
  margin-left: 300px;
}
td{
  font-family: sans-serif;
  font-size: 20px;
  font-weight: bold;
}
td a{
  text-decoration: none;
  color: #42424b;
}
td a:hover{
  color: cornflowerblue;
}
tr{
  display: grid;
  grid-template-columns: 400px 50px 50px;
  /*background-color: rgb(218, 218, 222, 0.2);*/
  background: rgba(126, 192, 227, 0.05);
  border-radius: 5px;
  margin-left: 200px;
}
.icon {
  font-size: 2rem;
}
.edit{
  color: mediumseagreen;
  text-align: center;
}
.delete{
  color: red;
  text-align: center;
}
</style>