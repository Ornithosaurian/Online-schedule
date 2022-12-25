import http from "../http-common";

class NewS{

    get(){
        return http.get('/news')
    }
    getById(id){
        return http.get(`/news/${id}`)
    }
    delete(id){
        return http.delete(`/news/${id}`)
    }
    update(id,data){
        return http.put(`/news/${id}`,data)
    }
    add(data){
        return http.post('/news',data)
    }
}
export default new NewS();