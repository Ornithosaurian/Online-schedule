<template>
  <Header class="header"></Header>
  <div class="add"><router-link class="link" :to="{name:'addFaculty'}">
    <font-awesome-icon class="icon" icon="circle-plus" /> Add new Faculty</router-link></div>
  <h1 class="f_h">Faculties</h1>
  <table>
    <tr v-for="faculty in faculties" v-bind:key="faculty.id">
      <td><router-link :to="`/faculties/${faculty.id}`">{{faculty.shortName}}</router-link></td>
    </tr>
  </table>

  <Footer class="footer"></Footer>

</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import FacultyS from "../../services/FacultyS.js"

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
      FacultyS.get().then((response)=>{
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
.add{
  margin-left: 30px;
  width: 250px;
  font-family: sans-serif;
  font-size: 20px;
}
.link{
  text-decoration: none;
  color: cornflowerblue;
}
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
  width:200px ;
  margin-left: 500px;
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
  grid-template-columns: 115px;
  background: rgba(126, 192, 227, 0.05);
  border-radius: 5px;
  margin-left: 200px;
}
.icon {
  font-size: 2rem;
}
</style>