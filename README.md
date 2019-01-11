# Volume-Balok
Aplikasi Volume Balok adalah aplikasi yang memudahkan kita dalam menghitung sebuah volume pada bidang ruang yaitu Balok.

---
**Fitur dan Menu :**

- [x] Menggunakan konsep UX & UI
- [x] Menghitung volume balok sesuai dengan rumus
- [x] Membuat halaman splashcreen
- [x] Ketika posisi layar landscape hasil volume tidak hilang

---
**Screenshoot Aplikasi :**
---
|  |  | | |
| ----- | --- | ----- | --- |
| ![Gambar aplikasi](https://github.com/fajaregafirmansyah/Volume-Balok/blob/master/Gambar/1.jpg)   | ![Gambar aplikasi](https://github.com/fajaregafirmansyah/Volume-Balok/blob/master/Gambar/2.jpg)  | ![Gambar aplikasi](https://github.com/fajaregafirmansyah/Volume-Balok/blob/master/Gambar/3.jpg) | ![Gambar aplikasi](https://github.com/fajaregafirmansyah/Volume-Balok/blob/master/Gambar/4.jpg)  |

---
**Library yang digunakan :**
---
* Glide
* AppCompat (Toolbar, CardView, etc)
* Databinding

---
> Semoga bermanfaat....

## Design Flow Untuk Chat Integration

```plantuml
    participant "Partner Apps" as A
    participant "Sendbird" as B
    participant "api-indihome" as C 
    participant "api-Mytech" as D 
    participant "Mytech Apps" as E

    title New Flow Integration

    A -> B: Create User()
    A -> C: Get Laborcode()
    A -> C: Get Room Chat()
     alt Chat Ada
	A -> B: load room chat()
        A -> C: Send Notif()
        C -> D: Send Notif()
        D -> E: Send Notif()
        E -> E: Open Notif()
        E -> B: Create User()
        E -> B: load room chat()
     else Chat Tidak ada
        A -> B: Create Room()
        A -> C: Save Room Chat()
        A -> C: Send Notif()
        C -> D: Send Notif()
        D -> E: Send Notif()
        E -> E: Open Notif()
        E -> B: Create User()
        E -> B: load room chat()
     end
    
```

**Follow akun github saya :**
https://github.com/fajaregafirmansyah

**Follow akun instagram saya :**
https://www.instagram.com/fajaregaf/

