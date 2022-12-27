<template>
  <Header class="header"></Header>
  <h1 class="t_h">Add New</h1>

  <h2 >Enter  title:</h2>
  <input type="text" v-model="news.title"><br>
  <h2 >Enter image url:</h2>
  <input type="text" v-model="news.imgSrc"><br>
  <h2 >Enter description:</h2>
  <input type="text" v-model="news.description"><br>

  <button @click="addNews">Add</button>

  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import NewS from "../../services/NewS.js"

export default {
  name: "AddTeacher",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      news:{
        title:'',
        imgSrc:'',
        description:''
      }
    }
  },
  methods: {
    addNews(){
      NewS.add(this.news).then(response=>{console.log('Added successfully')})
      this.$router.push('/news')
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