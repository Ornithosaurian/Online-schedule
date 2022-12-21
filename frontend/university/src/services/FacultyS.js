import http from "../http-common.js";

class FacultyS{

    get(){
        return http.get('/faculties')
    }
    getById(id){
        return http.get(`/faculties/${id}`)
    }
    delete(id){
        return http.delete(`/faculties/${id}`)
    }
}
export default new FacultyS();