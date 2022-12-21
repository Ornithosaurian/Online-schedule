import http from "../http-common";

class NewS{

    get(){
        return http.get('/news')
    }
    get(id){
        return http.get(`/news/${id}`)
    }
    delete(id){
        return http.delete(`/news/${id}`)
    }
}
export default new NewS();