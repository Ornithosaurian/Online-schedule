<template>
  <Header class="header"></Header>
  <div class="icons">
    <div><router-link class="edit" :to="{name:'editNew', params:{ne_id:news.id}}">
      <font-awesome-icon class="icon" icon="pen-to-square" />
    </router-link></div>
    <div class="delete" @click="deleteNew">
      <font-awesome-icon class="icon" icon="trash-can"/>
    </div>
  </div>
  <div v-if="news">
    <h1 class="t_h">{{news.title}}</h1>

    <img class="img" :src="news.imgSrc"/>
    <p>{{news.description}}</p>
  </div>
  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import NewS from "../../services/NewS.js"

export default {
  name: "New",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      news:null
    }
  },
  methods:{
    getNew(id){
      NewS.getById(id).then((response)=>{
        this.news=response.data;
      })
    },
    deleteNew(){
      NewS.delete(this.news.id).then(response=>{console.log('Deleted successfully')})
      this.$router.push('/news')
    }
  },
  created(){
    this.getNew(this.$route.params.n_id)
  }}
</script>

<style scoped>
.icons{
  display: grid;
  grid-template-columns: 50px 50px;
  grid-column-gap: 10px;
}
.ref{
  font-size: 19px;
  font-weight: bold;
  font-family: sans-serif;
  text-decoration: none;
  margin-left: 630px;
  color: #7ec0e3;
}
.ref:hover{
  color: #42424b;
}
.img{
  margin-left: 625px;
  width:300px;
  height: 250px;
}
p{
  width: 800px;
  font-family: sans-serif;
  font-weight: bold;
  font-size: 16px;
  text-align: center;
  margin-left: 350px;
}

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
.edit:hover{
  color: black;
}
.delete{
  color: red;
  text-align: center;}

.delete:hover{
  color: black;
}
</style>