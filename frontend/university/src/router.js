import{createRouter, createWebHashHistory} from "vue-router";
import EditFaculty from "@/components/editPages/EditFaculty.vue";

export default createRouter({
    history: createWebHashHistory(),
        routes:[
            {path:'/editFaculty',component: EditFaculty}
        ]
    }
)