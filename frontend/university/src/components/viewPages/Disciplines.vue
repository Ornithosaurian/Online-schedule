<template>
  <Header class="header"></Header>

  <h1 class="d_h">Disciplines</h1>
  <div class="add"><router-link class="link" :to="{name:'addDiscipline'}">
    <font-awesome-icon class="icon" icon="circle-plus" /> Add new discipline</router-link></div>
  <table>
    <tr v-for="discipline in disciplines" v-bind:key="discipline.id">
      <td>{{discipline.name}}</td>
      <td><router-link class="edit" :to="{name:'discipline_edit', params:{ds_id:discipline.id}}">
        <font-awesome-icon class="icon" icon="pen-to-square" />
      </router-link></td>
      <td class="delete" @click="deleteDiscipline(discipline.id)"><font-awesome-icon class="icon" icon="trash-can" /></td>
    </tr>
  </table>

  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import DisciplineS from "../../services/DisciplineS.js"

export default {
  name: "Disciplines",
    components: {
      Header,
      Footer
    },
  data(){
    return{
      disciplines:[]
    }
  },
  methods:{
    getDisciplines(){
      DisciplineS.get().then((response)=>{
        this.disciplines=response.data;
      })
    },
    deleteDiscipline(id){
      DisciplineS.delete(id).then(response=>{console.log('Deleted successfully')})
      this.$router.go('/disciplines')
    }
  },
  created(){
    this.getDisciplines()
  }
  }

</script>

<style scoped>
header{
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

.d_h{
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

tr{
  display: grid;
  grid-template-columns: 400px 50px 50px;
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
  color: #1f1e1e;
}
.delete{
  color: red;
  text-align: center;
}
.delete:hover{
  color: black;
}
</style>