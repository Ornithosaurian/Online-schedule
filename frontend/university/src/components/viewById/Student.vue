<template>
  <Header class="header"></Header>
  <div class="icons">
    <div><router-link class="edit" :to="{name:'editStudent', params:{se_id:student.id}}">
      <font-awesome-icon class="icon" icon="pen-to-square" />
    </router-link></div>
    <div class="delete" @click="deleteStudent">
      <font-awesome-icon class="icon" icon="trash-can"/>
    </div>
  </div>
  <h1 class="t_h">Student</h1>
  <div v-if="student">
    <table>
      <tr>
        <td>Last name:</td>
        <td>{{student.surname}}</td>
      </tr>
      <tr>
        <td>First name:</td>
        <td>{{student.name}}</td>
      </tr>
      <tr>
        <td>Patronymic:</td>
        <td>{{student.patronymic}}</td>
      </tr>
      <tr>
        <td>Email:</td>
        <td>{{student.email}}</td>
      </tr>
      <tr>
        <td>Phone number:</td>
        <td>{{student.phone}}</td>
      </tr>
    </table>
  </div>
  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import StudentS from "../../services/StudentS.js"

export default {
  name: "Student",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      student:null
    }
  },
  methods:{
    getStudent(id){
      StudentS.getById(id).then((response)=>{
        this.student=response.data;
      })
    },
    deleteStudent(){
      StudentS.delete(this.student.id).then(response=>{console.log('Deleted successfully')})
      this.$router.push({name:'group'})
    }
  },
  created(){
    this.getStudent(this.$route.params.s_id)
  }}
</script>

<style scoped>

.icons{
  display: grid;
  grid-template-columns: 50px 50px;
  grid-column-gap: 10px;
}
.header{
  margin-bottom: 60px;
}

.footer{
  position:static;
  bottom:0;
  margin-top: 125px;
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
.edit:hover{
  color: black;
}
.delete{
  color: red;
  text-align: center;
}
.delete:hover{
  color: black;
}
</style>