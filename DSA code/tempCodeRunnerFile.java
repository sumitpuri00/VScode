
                void push(int data){
                        
                        if(s1.isEmpty()){
                                s1.push(data);
                                return;
                        }else{
                                while(!s1.isEmpty()){
                                        s2.push(s1.pop());
                                }
                                s1.push(data);
                        }
                        while(!s2.isEmpty()){