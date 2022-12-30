<template>
  <Header class="header"></Header>
  <h1 class="t_h">Discipline</h1>
  <div v-if="discipline">
    <h2 >Edit discipline name:</h2>
    <input type="text" v-model="discipline.name"><br>
    <button @click="updateDiscipline">Save</button>
  </div>
  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import DisciplineS from "../../services/DisciplineS.js"

export default {
  name: "EditDiscipline",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      discipline:null
    }
  },
  methods:{
    getDiscipline(id){
      DisciplineS.getById(id).then((response)=>{
        this.discipline=response.data;
      })
    },
    updateDiscipline(){
      DisciplineS.update(this.discipline.id, this.discipline).then(response=>{console.log('Updated successfully')})
      this.$router.push('/disciplines')
    }
  },
  created(){
    this.getDiscipline(this.$route.params.ds_id)
  }
}
</script>

<style scoped>
.header{
  margin-bottom: 60px;
}

.footer{
  position:static;
  bottom:0;
  margin-top: 180px;
}
button{
  margin-left: 720px;
  margin-top: 20px;
  width: 80px;
  height: 50px;
  font-size: 20px;
  font-family: sans-serif;
  background-color: rgba(115, 196, 239, 0.81);

}
h2{
  font-size: 25px;
  font-weight: bold;
  font-family: sans-serif;
  text-align: center;
  color: #42424b;
}
input{
  width: 600px;
  height: 25px;
  margin-left: 450px;
  font-family: sans-serif;
  font-size: 15px;
}
.t_h{
  color: #42424b;
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
  font-family: sans-serif;
}


</style>