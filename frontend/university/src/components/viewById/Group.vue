<template>
  <Header class="header"></Header>
  <div class="icons">
    <div class="edit"><font-awesome-icon class="icon" icon="pen-to-square" /></div>
    <div class="delete" @click="deleteGroup"><font-awesome-icon class="icon" icon="trash-can" /></div>
  </div>
  <div v-if="group">
    <h1 class="f_h">Students of {{group.name}}</h1>
    <p>Course: {{group.course}}</p>
    <table>
      <tr v-for="student in group.students" v-bind:key="student.id">
        <td><router-link :to="{name:'student', params:{s_id:student.id}}">{{student.name}} {{student.surname}}</router-link></td>
        <td class="edit"><font-awesome-icon class="icon" icon="pen-to-square" /></td>
        <td class="delete"><font-awesome-icon class="icon" icon="trash-can" /></td>
      </tr>
    </table>
  </div>
  <Footer class="footer"></Footer>

</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import GroupsS from "../../services/GroupS.js"

export default {
  name: "Group",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      group:null
    }
  },
  methods:{
    getGroup(id){
      GroupsS.getById(id).then((response)=>{
        this.group=response.data;
      });
    },
    deleteGroup(){
      GroupsS.delete(this.group.id).then(response=>{console.log('Deleted successfully')})
      this.$router.push({name:'groups'})
    }
  },
  created(){
    this.getGroup(this.$route.params.g_id)
  }}

</script>

<style scoped>
.icons{
  display: grid;
  grid-template-columns: 50px 50px;
  grid-column-gap: 10px;
}
p{
  margin-left: 650px;
  font-family: sans-serif;
  font-weight: bold;
  font-size: 20px;
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
.delete{
  color: red;
  text-align: center;
}
.delete:hover{
  color: black;
}
</style>