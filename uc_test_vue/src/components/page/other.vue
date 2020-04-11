<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 员工列表2
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        
        <!-- <div class="container">
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
            </div> -->
              <el-table
                :data="tableData1()"
                style="width: 100%">
                <el-table-column type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-table
                            :data="tableData2(props.row)"
                            border
                            class="table"
                            ref="multipleTable"
                            header-cell-class-name="table-header"
                            @selection-change="handleSelectionChange"
                        >
                            <el-table-column prop="itemid" label="itemid"></el-table-column>
                            <el-table-column prop="itemNum" label="itemNum"></el-table-column>
                        </el-table> 
                    </el-form>
                </template>
                </el-table-column>
                <el-table-column label="ID" prop="id"></el-table-column>
                <el-table-column label="名称" prop="name"></el-table-column>
                <el-table-column label="描述" prop="remark"> </el-table-column>
                <el-table-column label="创建时间" prop="createTime"> </el-table-column>
            </el-table>
          
        </div>
    </div>
</template>

<script>
export default {
    name: 'other',
    inject:['reload'],
    data() {
        return {
            tableData: []
        };
    },
    created() {
        this.getList();
    },
    
    methods: {
        tableData1(){
              return this.tableData.map(it => {
                    if(it.createDate){
                        it.createTime = it.createDate.toString();
                        it.createTime = it.createTime.substring(0,10)
                    }
                    return it;
                });
        },
        getList(){
            this.axios.get("other/list").then(res=>{
                console.log("res2222222222: ",res);
                if(res.data.state===200){
                    this.tableData = res.data.data;
                }
            })
        },
        tableData2(row){
            console.log("row: ",row);
            let rep = JSON.parse(row.content);
            return rep;
        },
        handleSelectionChange(){
         },
          delAllSelection(){ 
        },
        handleSearch(){}
    },
    watch:{
    $route(to,from){
        this.reload();
    }
},
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
.block{
    text-align: end;
}
</style>
