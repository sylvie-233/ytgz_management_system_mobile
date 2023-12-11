<template>
    <div class="login-page">
        <div></div>
        <div class="login-box">
            <van-form @submit="onSubmit">
                <van-cell-group inset>
                    <van-field
                        v-model="username"
                        name="用户名"
                        label="用户名"
                        placeholder="用户名"
                        :rules="[{ required: true, message: '请填写用户名' }]"
                        />
                    <van-field
                        v-model="password"
                        type="password"
                        name="密码"
                        label="密码"
                        placeholder="密码"
                        :rules="[{ required: true, message: '请填写密码' }]"
                    />
                </van-cell-group>
                <div style="margin: 16px;">
                    <van-button round block type="primary" native-type="submit">
                    提交
                    </van-button>
                </div>
            </van-form>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from "vue"
import { useRouter } from "vue-router"

const router = useRouter()

const username = ref<string>()
const password = ref<string>()


const onSubmit = (values: any) => {
    console.log(values)
    window.localStorage.setItem("token", "sylvie233")
    router.push({
        name: "main"
    })
}

</script>

<style lang="less">
.login-page {
    display: flex;
    justify-content: center;
    align-items: center;
    .login-box {
        width: 100%;
        margin-top: 240px;
    }
}
</style>