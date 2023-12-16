import axios from "axios"
import AdminConfig from "@/config"

axios.defaults.headers.common["Content-Type"] = "application/json;charset=utf-8"

const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: AdminConfig.baseUrl,
    // 超时
    timeout: 10000
})


export default service