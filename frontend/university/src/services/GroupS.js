import http from "../http-common";

class GroupS{

    get(){
        return http.get('/groups')
    }
    getById(id){
        return http.get(`/groups/${id}`)
    }
    delete(id){
        return http.delete(`/groups/${id}`)
    }
    update(id,data){
        return http.put(`/groups/${id}`,data)
    }
    add(data){
        return http.post('/groups',data)
    }
}
export default new GroupS();