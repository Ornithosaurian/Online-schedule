import {createRouter, createWebHashHistory} from "vue-router";
import EditFaculty from "@/components/editPages/EditFaculty.vue";
import EditDepartment from "@/components/editPages/EditDepartment.vue"
import EditDiscipline from "@/components/editPages/EditDiscipline.vue"
import EditDGroup from "@/components/editPages/EditGroup.vue"
import EditStudent from "@/components/editPages/EditStudent.vue"
import EditTeacher from "@/components/editPages/EditTeacher.vue"
import Departments from "@/components/viewPages/Departments.vue"
import Disciplines from "@/components/viewPages/Disciplines.vue"
import Faculties from "@/components/viewPages/Faculties.vue"
import Groups from "@/components/viewPages/Groups.vue"
import Teachers from "@/components/viewPages/Teachers.vue"
import Student from "@/components/viewById/Student.vue"
import News from "@/components/viewPages/News.vue"
import Faculty from "@/components/viewById/Faculty.vue"
import Department from "@/components/viewById/Department.vue"
import Group from "@/components/viewById/Group.vue"
import Teacher from "@/components/viewById/Teacher.vue"
import New from "@/components/viewById/New.vue"


export default createRouter({
        history: createWebHashHistory(),
        routes: [
            {path: '/', redirect: '/news'},
            {path: '/editFaculty', component: EditFaculty},
            {path: '/editDepartment', component: EditDepartment},
            {path: '/faculties', name:'faculties',component: Faculties},
            {path: '/faculties/:f_id', component: Faculty},
            {path: '/faculties/:f_id/departments', name: 'faculty_departments', component: Departments},
            {path: '/faculties/:f_id/departments/:d_id', name: 'department', component: Department},
            {path: '/faculties/:f_id/departments/:d_id/groups', name: 'department_groups', component: Groups},
            {path: '/faculties/:f_id/departments/:d_id/groups/:g_id', name: 'department_group', component: Group},
            {path: '/faculties/:f_id/departments/:d_id/groups/:g_id/student/:s_id',name:'student', component: Student},
            {path: '/teachers',name:'teachers', component: Teachers},
            {path: '/teachers/:t_id', name:'teacher', component: Teacher},
            {path: '/news', component: News},
            {path: '/news/:n_id',name:'new', component: New},
            {path: '/disciplines', component: Disciplines}
        ]
    }
)