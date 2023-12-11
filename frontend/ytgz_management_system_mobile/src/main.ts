import { createApp } from 'vue'
import './styles/style.css'
import 'vant/lib/index.css';
import App from './App.vue'
import Vant from "vant"
import router from './router'

// 项目app
const app = createApp(App)

// 使用 vue-router@4 构建路由
app.use(router)

app.use(Vant)

app.mount('#app')
