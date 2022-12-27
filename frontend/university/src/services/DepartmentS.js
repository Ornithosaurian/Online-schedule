import http from "../http-common.js";

class DepartmentS{

    get(){
        return http.get('/departments')
    }
    getById(id){
        return http.get(`/departments/${id}`)
    }
    delete(id){
        return http.delete(`/departments/${id}`)
    }
    update(id,data){
        return http.put(`/departments/${id}`,data)
    }
    add(data){
        return http.post('/departments',data)
    }
}
export default new DepartmentS();