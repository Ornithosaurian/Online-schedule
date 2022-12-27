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
    add(data){
        return http.post(`/faculties`, data)
    }
    update(id,data){
        return http.put(`/faculties/${id}`,data)
    }
}
export default new FacultyS();