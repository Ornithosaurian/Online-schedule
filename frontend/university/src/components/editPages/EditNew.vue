<template>
  <Header class="header"></Header>
  <div v-if="news">
  <h1 class="t_h">Edit New</h1>

  <h2 >Edit  title:</h2>
  <input type="text" v-model="news.title"><br>
  <h2 >Edit image url:</h2>
  <input type="text" v-model="news.imgSrc"><br>
  <h2 >Edit description:</h2>
  <input type="text" v-model="news.description"><br>

  <button @click="updateNews">Save</button>
  </div>
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
      news:null
    }
  },
  methods: {
    getNew(id){
      NewS.getById(id).then((response)=>{
        this.news=response.data;
      })
    },
    updateNews(){
      NewS.update(this.news.id, this.news).then(response=>{console.log('Edited successfully')})
      this.$router.push({name:'new', params:{n_id:this.news.id}})
    }
  },
  created(){
    this.getNew(this.$route.params.ne_id)
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