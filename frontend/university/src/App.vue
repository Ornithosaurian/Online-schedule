<script>
import EditFaculty from '../src/components/editPages/EditFaculty.vue'
import New from '../src/components/news/New.vue'
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  components: {
    Header,
    New,
    Footer
  }
}

</script>

<template>
  <Header></Header>
  <h1 class="news_h">News</h1>
  <router-view></router-view>
  <div class="wrapper">
  <New></New>
  <New></New>
  <New></New>
  <New></New>
  <New></New>
  <New></New>
  <New></New>
  <New></New>
  </div>
  <Footer></Footer>
</template>

<style scoped>

.wrapper{
  display: grid;
  grid-template-columns: 300px 300px 300px 300px;
  grid-column-gap: 100px;
  grid-row-gap: 100px;
}
.news_h{
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
}
</style>