import http from "../http-common";

class TeacherS{

    get(){
        return http.get('/teachers')
    }
    get(id){
        return http.get(`/teachers/${id}`)
    }
    delete(id){
        return http.delete(`/teachers/${id}`)
    }
}
export default new TeacherS();