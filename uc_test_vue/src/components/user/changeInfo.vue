<template>
  <div class="info">
      <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 修改信息
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
    <el-row>
        <el-col :span="24" class="col-name">
              <el-form ref="form" :model="params" label-width="80px">
                <el-form-item label="姓名">
                  <el-input v-model="params.name"></el-input>
                </el-form-item>
                
                <el-form-item label="性别">
                  <el-radio-group v-model="params.sex">
                    <el-radio :label="0">男</el-radio>
                    <el-radio :label="1">女</el-radio>
                  </el-radio-group>
                </el-form-item>

                <!-- <el-form-item label="年龄">
                  <el-input v-model="params.age"></el-input>
                </el-form-item> -->

                <el-form-item label="地址">
                  <el-input v-model="params.address"></el-input>
                </el-form-item>

                <el-form-item label="手机号">
                  <el-input v-model="params.tel"></el-input>
                </el-form-item>
                
                <el-form-item label="入职时间">
                 <div class="block">
                    <el-date-picker
                    v-model="params.joinDate"
                    type="date"
                    placeholder="选择日期">
                    </el-date-picker>
                </div>
                </el-form-item>
                
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">修改</el-button>
                  <el-button @click="goback">取消</el-button>
                </el-form-item>
              </el-form>
             </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
    name: 'changeInfo',
     data() {
      return {
        params:{
          name:'',
          tel:'',
          sex:'',
        //   age:'',
          address:'',
          joinDate:''
        }
      };
    },
    methods: {
       onSubmit() {
        console.log('submit:',this.params);
        this.axios.post("person/change",this.params).then(res=>{
          console.log("res: ",res);
          if(res.data.state==200){
            this.$message.success("修改成功");
            this.$router.push("user");
          }
        })
      },
      goback(){
        this.$router.push("user");
      }
    },
    created(){
        this.params =  this.$route.query.info;
    }
}
</script>

<style>
.section-title {
  border-bottom: solid 1px #f0f0f0;
  padding: 10px 10px;
  color: #acacac;
  background-color: #fbfbfb;
  margin: 10px 0;
}
.info{
    text-align: left;
}
/* .col-name div{
    padding: 15px;
} */
 .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }
  .avatar {
    width: 100px;
    height: 100px;
    display: block;
  }
  .col-name .el-input__inner{
    width: 300px;
  }
  .el-textarea__inner{
    width: 730px;
  }
  .el-col-11{
    width:300px;
  }
</style>