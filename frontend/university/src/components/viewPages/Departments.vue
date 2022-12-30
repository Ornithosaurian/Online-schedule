<template>
  <Header class="header"></Header>
  <div class="add"><router-link class="link" :to="{name:'addDepartment'}">
    <font-awesome-icon class="icon" icon="circle-plus" /> Add new Department</router-link></div>
  <div v-if="faculty">
  <h1 class="f_h">Departments of {{faculty.shortName}}</h1>
  <table>
    <tr v-for="department in faculty.departments" v-bind:key="department.id">
      <td><router-link :to="{name:'department', params:{d_id:department.id}}">{{department.shortName}}</router-link></td>
    </tr>
  </table>
  </div>
  <Footer class="footer"></Footer>

</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import FacultyS from "../../services/FacultyS.js"

export default {
  name: "Faculty",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      faculty:null
    }
  },
  methods:{
    getFaculty(id){
      FacultyS.getById(id).then((response)=>{
        this.faculty=response.data;
      });
    }
  },
  created(){
    this.getFaculty(this.$route.params.f_id)
  }}

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
  position:static;
  bottom:0;
  margin-top: 185px;
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
  grid-template-columns: 70px;
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