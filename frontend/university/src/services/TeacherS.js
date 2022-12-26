import http from "../http-common";

class TeacherS{

    get(){
        return http.get('/teachers')
    }
    getById(id){
        return http.get(`/teachers/${id}`)
    }
    delete(id){
        return http.delete(`/teachers/${id}`)
    }
    update(id,data){
        return http.put(`/teachers/${id}`,data)
    }
    add(data){
        return http.post('/teachers',data)
    }
}
export default new TeacherS();