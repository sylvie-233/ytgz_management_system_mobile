<template>
    <el-card class="login-form-layout">
      <el-form autoComplete="on"
               :model="loginForm"
               :rules="loginRules"
               ref="loginFormRef"
               label-position="left"
               class="login-form"
               >
        <div style="text-align: center">
            <span>道州玉潭(东阳)学校高中教务系统</span>
        </div>
        <h2 class="login-title color-main">道州玉潭(东阳)学校高中教务系统</h2>
        <el-form-item prop="username">
          <el-input name="username"
                type="text"
                v-model="loginForm.username"
                autoComplete="on"
                placeholder="请输入用户名"
                size="large"
                :prefix-icon="User"
            >
            <span slot="prefix">
                <svg-icon icon-class="user" class="color-main"></svg-icon>
            </span>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input name="password"
                    :type="pwdType"
                    @keyup.enter="submitForm(loginFormRef)"
                    v-model="loginForm.password"
                    autoComplete="on"
                    placeholder="请输入密码"
                    size="large"
                    :prefix-icon="Lock"
                    >
          <span slot="prefix">
            <svg-icon icon-class="password" class="color-main"></svg-icon>
          </span>
            <span slot="suffix" @click="showPwd">
            <svg-icon icon-class="eye" class="color-main"></svg-icon>
          </span>
          </el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 60px;">
          <el-row justify="space-around">
            <el-col :span="6">
                <el-button  type="primary" :loading="loading" @click="submitForm(loginFormRef)">
                    登录
                </el-button>
            </el-col>
            <el-col :span="6">
                <el-button type="primary" @click="registerForm">
                    注册
                </el-button>
            </el-col>
          </el-row>
        </el-form-item>
      </el-form>
    </el-card>
    <img :src="login_center_bg" class="login-center-layout">
</template>

<script setup lang="ts">
import { FormInstance, FormRules } from "element-plus";
import { reactive, ref } from "vue"
import login_center_bg from "@/assets/images/login_center_bg.png"
import { User, Lock } from "@element-plus/icons-vue";

interface RuleForm {
  username: string
  password: string
}


const validateUsername = (rule: any, value: any, callback: any) => {
    if (!value) {
        callback(new Error('请输入正确的用户名'))
    } else {
        callback()
    }
}
const validatePass = (rule: any, value: any, callback: any) => {
    if (value.length < 3) {
        callback(new Error('密码不能小于3位'))
    } else {
        callback()
    }
}

const loginRules: FormRules<RuleForm> = {
    username: [{required: true, trigger: 'blur', validator: validateUsername}],
    password: [{required: true, trigger: 'blur', validator: validatePass}]
}

const pwdType = ref<string>("password")
const showPwd = () => {
    if (pwdType.value === "password") {
        pwdType.value = ""
    } else {
        pwdType.value = "password"
    }
}

const loginForm = reactive({
    username: "",
    password: ""
})

const loading = ref<boolean>(false)


const loginFormRef = ref<FormInstance>()
const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('登录成功!')
      // TODO 处理登录逻辑
      loading.value = true
    } else {
      console.log('登录失败', fields)
    }
  })
}

const registerForm = () => {}


</script>

<style lang="less" scoped>
.login-form-layout {
    position: absolute;
    left: 0;
    right: 0;
    width: 480px;
    margin: 140px auto;
    border-top: 10px solid #409EFF;
    h2 {
        margin: 20px 0;
    }
    .login-form {
        font-size: 18px;
        .el-form-item {
            padding: 10px;
        }
    }
    .login-title {
        text-align: center;
    }
    .el-row {
        width: 100%;
        .el-button {
            width: 100%;
        }
    }
}

.login-center-layout {
    background: #409EFF;
    width: auto;
    height: auto;
    max-width: 100%;
    max-height: 100%;
    margin-top: 200px;
}
</style>