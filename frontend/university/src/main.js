import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router";

import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { fas } from '@fortawesome/free-solid-svg-icons'

/* add icons to the library */
library.add(fas)
// import './assets/main.css'

createApp(App).use(router).component('font-awesome-icon', FontAwesomeIcon).mount('#app')
