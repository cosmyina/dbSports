import {Injectable} from '@angular/core';
import {Router, Routes} from '@angular/router';
 
export class AdminUser {
  constructor(
    public username: string,
    public password: string) { 

    }
}
 
var users = [
  new AdminUser('admin','admin')
 
];
@Injectable()
export class AdminService {
    router: Router;
  constructor(
    private _router: Router){
        this.router = _router;
    }
 
  logout() {
    localStorage.removeItem("user");
    this.router.navigate(['/events']);
  }
 
  login(user){
    var authenticatedUser = users.find(admin => admin.username === user.username);
    debugger;
    if (authenticatedUser && authenticatedUser.password === user.password){
   //   localStorage.setItem("user", authenticatedUser);
      this.router.navigate(['/admin/edit']);    
      return true;
    }
    return false;
 
  }
 
   checkCredentials(){
    if (localStorage.getItem("user") === null){
        this._router.navigate(['Admin']);
    }
  } 
}
