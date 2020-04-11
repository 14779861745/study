<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 员工列表
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button
                    type="primary"
                    icon="el-icon-delete"
                    class="handle-del mr10"
                    @click="delAllSelection"
                >批量删除</el-button>
                <el-input v-model="query.name" placeholder="员工姓名" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleAdd">新增</el-button>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
            </div>
            <el-table
                :data="tableDataFilter()"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="员工姓名"></el-table-column>
                <el-table-column prop="sexName" label="员工性别"></el-table-column>
                <el-table-column prop="age" label="员工年龄"></el-table-column>
                <el-table-column prop="address" label="员工地址"></el-table-column>
                <el-table-column prop="joinTime" label="入职时间"></el-table-column>
                <el-table-column prop="statusName" label="当前状态"></el-table-column>
                <el-table-column prop="createTime" label="创建时间"></el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>

<script>
export default {
    name: 'userList',
    data() {
        return {
            query: {
                name: ''
            },
            tableData: [],
            multipleSelection: [],
        };
    },
    created() {
        this.getList();
    },
    methods: {
         tableDataFilter() {
                let sexName = {
                    0: "男",
                    1: "女"
                };
                let statusName = {
                    0: "在职",
                    1: "离职"
                };
                
                return this.tableData.map(it => {
                    it.sexName = sexName[it.sex];
                    console.log("res:",it.createDate);
                    if(it.status){
                        it.statusName = it.status==true?statusName[0]:statusName[1];
                    }
                    if(it.joinDate){
                        it.joinTime = it.joinDate.toString();
                        it.joinTime = it.joinTime.substring(0,10)
                    }
                    if(it.createDate){
                        it.createTime = it.createDate.toString();
                        it.createTime = it.createTime.substring(0,10)
                    }
                    return it;
                });
            },
        getList(){
            this.axios.get("person/list").then(res=>{
                console.log("res: ",res);
                if(res.data.state===200){
                    this.tableData = res.data.data;
                }
            })
        },
        delAllSelection(){ 
        },
        handleSearch(){}
    }
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
