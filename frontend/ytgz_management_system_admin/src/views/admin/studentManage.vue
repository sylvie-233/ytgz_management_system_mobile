<template>
    <div class="stu-manage-box">
        <el-card body-style="height: calc(100% - 40px);display:flex;flex-direction:column;">
            <div class="box-header">233</div>
            <div class="box-content">
                <div style="height: 200px;border: 1px;width: 200px;background-color: black;"></div>
                <div style="height: 200px;border: 1px;width: 200px;background-color: black;"></div>
                <div style="height: 200px;border: 1px;width: 200px;background-color: black;"></div>
                <div style="height: 200px;border: 1px;width: 200px;background-color: black;"></div>
                <div style="height: 200px;border: 1px;width: 200px;background-color: black;"></div>
                <div style="height: 200px;border: 1px;width: 200px;background-color: black;"></div>
            </div>
            <div class="box-footer">233</div>
        </el-card>
    </div>
</template>

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
        .box-content {
            flex: 1;
            overflow-y: hidden;
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
</style>