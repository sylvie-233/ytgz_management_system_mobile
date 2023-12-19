import axios from "axios"
import AdminConfig from "@/config"

axios.defaults.headers.common["Content-Type"] = "application/json;charset=utf-8"

const requset = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: AdminConfig.baseUrl,
    // 超时
    timeout: 10000
})

requset.interceptors.request.use((resp) => {
    return resp
}, (err) => {
    return Promise.reject(err)
})

requset.interceptors.response.use((resp) => {
    return resp
}, (err) => {
    return Promise.reject(err)
})


export default requset