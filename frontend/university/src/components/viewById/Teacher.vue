<template>
  <Header class="header"></Header>
<h1 class="t_h">Teacher</h1>
  <div v-if="teacher">
  <table>
    <tr>
      <td>Last name:</td>
      <td>{{teacher.surname}}</td>
    </tr>
    <tr>
      <td>First name:</td>
      <td>{{teacher.name}}</td>
    </tr>
    <tr>
      <td>Patronymic:</td>
      <td>{{teacher.patronymic}}</td>
    </tr>
    <tr>
      <td>Email:</td>
      <td>{{teacher.email}}</td>
    </tr>
    <tr>
      <td>Phone number:</td>
      <td>{{teacher.phone}}</td>
    </tr>
  </table>
  </div>
  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import TeacherS from "../../services/TeacherS.js"

export default {
  name: "Teacher",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      teacher:null
    }
  },
  methods:{
    getTeacher(id){
      TeacherS.getById(id).then((response)=>{
        this.teacher=response.data;
      });
    }
  },
  created(){
    this.getTeacher(this.$route.params.t_id)
  }}
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
  width:300px ;

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
  grid-template-columns: 200px 250px ;
  background: rgba(126, 192, 227, 0.05);
  border-radius: 5px;
  margin-left: 550px;
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