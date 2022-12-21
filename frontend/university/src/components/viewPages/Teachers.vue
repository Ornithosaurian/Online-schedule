<template>

<Header class="header"></Header>
  <h1 class="t_h">Teachers</h1>
<table>
  <tr v-for="teacher in teachers" v-bind:key="teacher.id">
    <td><router-link :to="{name:'teacher', params:{t_id:teacher.id}}">{{teacher.surname}} {{teacher.name}} {{teacher.patronymic}}</router-link></td>
    <td class="edit"><font-awesome-icon class="icon" icon="pen-to-square" /></td>
    <td class="delete"><font-awesome-icon class="icon" icon="trash-can" /></td>
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
  grid-template-columns: 1000px 50px 50px;
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