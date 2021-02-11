/**This class should be used to hold user details.
 * At the moment, it only stores username and password, 
 * but will be expanded as the application grows.
 */
export class User{

    private username:string;
    private password:string;

    constructor(){
        this.username = null;
        this.password = null;
    }


    public getUsername(): string {
        return this.username;
    }

    public setUsername(username: string): void {
        this.username = username;
    }

    public getPassword(): string {
        return this.password;
    }

    public setPassword(password: string): void {
        this.password = password;
    }
}