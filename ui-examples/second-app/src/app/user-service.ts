import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  http = inject(HttpClient);

  public getUsers(): Observable<any> {
    let url = 'http://localhost:9090/spring-boot-demo/api';
    return this.http.get(url);
  }
  // user will have 3 properties id, name and dob
  // call the saveUser by passing user object
  public saveUser(user: any): Observable<any> {
    let url = 'http://localhost:9090/spring-boot-demo/api';
    return this.http.post(url, user);
  }
  public authenticate(username: string, password: string): boolean {
    if (username == 'Admin' && password == 'admin123') {
      return true;
    } else {
      return false;
    }
  }
}
