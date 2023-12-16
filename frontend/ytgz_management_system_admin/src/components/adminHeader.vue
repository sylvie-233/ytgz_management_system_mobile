<template>
    <div class="admin-header">
        <div class="header-left">
            <el-icon><Fold /></el-icon>
        </div>
        <div class="header-right">right</div>
    </div>
</template>

<style lang="less"  scoped>
.admin-header {
    box-sizing: border-box;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    box-shadow: var(--el-box-shadow-light);
    .header-left {
        margin-left: 20px;
        font-size: 24px;
    }
    .header-right {
        margin-right: 20px;
    }
}
</style>