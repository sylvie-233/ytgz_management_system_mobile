<template>
    <div class="stu-manage-box">
        <el-card body-style="height: calc(100% - 40px);display:flex;flex-direction:column;">
            <div class="box-header">
                <div class="box-header-text">
                    学生管理
                </div>
                <div class="box-header-toolbar">
                    <div class="toolbar-left">
                        <el-select v-model="classSelect" placeholder="选择班级" size="large">
                            <el-option
                            v-for="item in classOptions"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                            />
                        </el-select>
                        <el-button class="toolbar-add" type="primary" :icon="CirclePlus">添加</el-button>
                    </div>
                    <div class="toolvar-right">
                        <el-input
                            v-model="searchText"
                            placeholder="搜索"
                            :prefix-icon="Search"
                        />
                    </div>
                </div>
            </div>
            <el-divider />
            <div class="box-content">
                <el-table :data="studentData" style="width: 100%" size="large">
                    <el-table-column prop="index" label="序号" />
                    <el-table-column prop="name" label="姓名" />
                    <el-table-column prop="gender" label="性别" />
                    <el-table-column prop="clazz" label="班级" />
                    <el-table-column prop="idcard" label="身份证" />
                    <el-table-column label="操作" label-class-name="table-action-label">
                        <template #default>
                            <div style="display: flex; align-items: center;justify-content: center;">
                                <el-button type="primary" plain>编辑</el-button>
                                <el-button type="danger" plain>删除</el-button>
                            </div>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <div class="box-footer">233</div>
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { reactive, ref, onMounted } from "vue";
import { Search, CirclePlus } from "@element-plus/icons-vue"
import { getStudentList } from "@/api/StudentAPI"


interface classOption {
    label: string
    value: string
}

interface studentInfo {
    index: number
    name: string
    gender: string
    // age: number
    clazz: string
}

let studentData = ref<studentInfo[]>([
])

const searchText = ref<string>("")
const classSelect = ref<string>("")
const classOptions = reactive<classOption[]>([
    {
        label: "G2304",
        value: "G2304"
    },
    {
        label: "G2305",
        value: "G2305"
    },
    {
        label: "G2306",
        value: "G2306"
    },
])

onMounted(() => {
    getStudentList().then((resp) => {
        console.log(resp)
        let newStudentDataArray: studentInfo[] = []
        for (let index = 0; index < resp.data.data?.length; index++) {
            let it = resp.data.data[index]
            newStudentDataArray.push(<studentInfo> {
                index: index + 1,
                name: it.name,
                gender: it.gender == 1 ? "男" : "女",
                clazz: it.clazz,
                idcard: it.idcard
            })
        }
        studentData.value = newStudentDataArray
    }).catch((err) => {

    })
})

</script>

<style lang="less" scoped>
.stu-manage-box {
    height: calc(100vh - 140px);
    padding: 0 20px;
    .el-card {
        height: 100%;
        padding: 20px;
        box-sizing: border-box;
        overflow: hidden;
        flex-direction: column;
        .box-header {
            .box-header-text {
                font-size: 28px;
                font-weight: bold;
            }
            .box-header-toolbar {
                margin-top: 10px;
                display: flex;
                justify-content: space-between;
                .toolbar-left {
                    display: flex;
                    align-items: center;
                    .toolbar-add {
                        margin-left: 20px;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        .el-icon {
                            font-size: 24px;
                        }
                    }
                }
                .toolvar-right {
                }
                
            }
        }
        .box-content {
            flex: 1;
            overflow-y: auto;
            &::-webkit-scrollbar {
                width: 8px;
            }
            &::-webkit-scrollbar-thumb {
                border-radius: 10px;
                background: rgba(0,0,0,0.2);
            }
            &::-webkit-scrollbar-track {
                border-radius: 0;
                background: rgba(0,0,0,0.1);
            }
            
        }
    }
}
:deep(.table-action-label) {
    text-align: center;
}
</style>