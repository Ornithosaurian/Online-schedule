<template>
  <Header class="header"></Header>
  <h1 class="t_h">Add department</h1>

  <h2 >Enter full name of department:</h2>
  <input type="text" v-model="department.name"><br>
  <h2 >Enter short name:</h2>
  <input type="text" v-model="department.shortName"><br>
  <h2 >Enter description:</h2>
  <input type="text" v-model="department.description"><br>
  <h2 >Enter imgSrc:</h2>
  <input type="text" v-model="department.imgSrc"><br>

  <button @click="addDepartment">Add</button>

  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import DepartmentS from "../../services/DepartmentS.js"

export default {
  name: "AddDepartment",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      department:{
        name:'',
        shortName:'',
        description:'',
        imgSrc:''
      }
    }
  },
  methods: {
    addDepartment(){
      DepartmentS.add(this.department).then(response=>{console.log('Added successfully')})
      this.$router.go(-1)
    }
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