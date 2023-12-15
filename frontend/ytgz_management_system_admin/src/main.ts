import { createApp } from 'vue'
import ElementPlus from "element-plus"
import * as ElementPlusIcons from '@element-plus/icons-vue'
import router from './router'


import 'element-plus/dist/index.css'
import "@/styles/index.css"

import App from './App.vue'

const app = createApp(App)

app.use(ElementPlus)
for (const [key, component] of Object.entries(ElementPlusIcons)) {
    app.component(key, component)
}
app.use(router)

app.mount('#app')
