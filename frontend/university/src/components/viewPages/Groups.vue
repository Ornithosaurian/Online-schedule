<template>
  <Header class="header"></Header>
  <div v-if="department">
    <div class="add"><router-link class="link" :to="{name:'addGroup'}">
      <font-awesome-icon class="icon" icon="circle-plus" /> Add new Group</router-link></div>
    <h1 class="f_h">Groups of {{department.shortName}}</h1>
    <table>
      <tr v-for="group in department.groups" v-bind:key="group.id">
        <td><router-link :to="{name:'group', params:{g_id:group.id}}">{{group.name}}</router-link></td>
        <td><router-link class="edit" :to="{name:'editGroup', params:{ge_id:group.id}}">
          <font-awesome-icon class="icon" icon="pen-to-square" />
        </router-link></td>
        <td class="delete" @click="deleteGroup">
          <font-awesome-icon class="icon" icon="trash-can"/>
        </td>
      </tr>
    </table>
  </div>
  <Footer class="footer"></Footer>

</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import DepartmentS from "../../services/DepartmentS.js"

export default {
  name: "Groups",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      department:null
    }
  },
  methods:{
    getDepartment(id){
      DepartmentS.getById(id).then((response)=>{
        this.department=response.data;
      });
    }
  },
  created(){
    this.getDepartment(this.$route.params.d_id)
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
.edit:hover{
  color: black;
}
.delete{
  color: red;
  text-align: center;
}
.delete:hover{
  color: #000;
}
</style>