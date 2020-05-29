const express=require('express');
const morgan=require('morgan');
const parser= require('body-parser');
const mongoose=require('mongoose');
const app=express();
const port=9000;

mongoose.set('useNewUrlParser', true);

mongoose.set('useUnifiedTopology', true);

mongoose.connect("mongodb+srv://aayush:aayush@cluster0-442xj.mongodb.net/test?retryWrites=true&w=majority",function(err){
    if(err){
        console.log("error");
    }
    else {
        console.log('Atlas connected')
    }
});
  
app.use(morgan('dev'));
app.use(parser.json());
app.use(parser.urlencoded({extended:true}));
app.use('*',function(req,res,next){
    res.set('Access-Control-Allow-Origin','*');
    res.set('Access-Control-Allow-Headers','content-type');
    res.set('Access-Control-Allow-Methods','*');
    next();
});



app.listen(port,function()
    {
        console.log(`Server is listening on ${port}`);
    }
);
        