<template>

<Header class="header"></Header>
  <h1 class="t_h">Teachers</h1>
  <div class="add"><router-link class="link" :to="{name:'addTeacher'}">
    <font-awesome-icon class="icon" icon="circle-plus" /> Add new teacher</router-link></div>
  <table>
  <tr v-for="teacher in teachers" v-bind:key="teacher.id">
    <td><router-link :to="{name:'teacher', params:{t_id:teacher.id}}">
      {{teacher.surname}} {{teacher.name}} {{teacher.patronymic}}</router-link></td>
  </tr>

</table>

  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import TeacherS from "../../services/TeacherS.js"

export default {
  name: "Teachers",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      teachers:[]
    }
  },
  methods:{
    getTeachers(){
      TeacherS.get().then((response)=>{
        this.teachers=response.data;
      });
    }
  },
  created(){
    this.getTeachers()
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

.t_h{
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
}
td{
  font-family: sans-serif;
  font-size: 22px;
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
  grid-template-columns: 500px;
  grid-row-gap: 100px;
  background: rgba(126, 192, 227, 0.05);
  border-radius: 5px;
  margin-left: 500px;
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