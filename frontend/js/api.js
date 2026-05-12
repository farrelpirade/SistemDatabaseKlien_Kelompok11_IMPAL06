// const BASE_URL = 'http://localhost:8080'; // Gunakan ini untuk testing lokal jika perlu
const BASE_URL = "https://backend-1777904718830.azurewebsites.net";

/**
 * Fungsi helper untuk melakukan HTTP Request ke Backend
 * Otomatis menambahkan header Authorization (JWT) jika tersedia
 */
async function fetchAPI(
  endpoint,
  method = "GET",
  bodyData = null,
  extraHeaders = {},
) {
  const token = localStorage.getItem("jwt_token");

  const headers = {
    "Content-Type": "application/json",
    ...extraHeaders,
  };

  // Jika token ada, masukkan ke header Bearer
  if (token) {
    headers["Authorization"] = `Bearer ${token}`;
  }

  const options = {
    method: method,
    headers: headers,
  };

  if (bodyData) {
    options.body = JSON.stringify(bodyData);
  }

  try {
    const response = await fetch(`${BASE_URL}${endpoint}`, options);

    // Menangani Unauthorized (401)
    if (response.status === 401) {
      const errText = await response.text();

      // Jika error 401 terjadi saat LOGIN, lemparkan error agar ditangkap form login
      if (endpoint.includes("/login")) {
        throw new Error(errText || "Username atau Password salah.");
      }
      // Jika terjadi di halaman lain, berarti token habis/tidak valid (Sesi Berakhir)
      else {
        alert(
          "Sesi Anda telah berakhir atau tidak valid. Silakan login kembali.",
        );
        logout(); // Memanggil fungsi logout yang ada di bawah
        return null;
      }
    }

    // Cek jika response error (selain 2xx)
    if (!response.ok) {
      const errText = await response.text();
      throw new Error(errText || `HTTP error! status: ${response.status}`);
    }

    // Ekstrak response body
    const contentType = response.headers.get("content-type");
    if (contentType && contentType.indexOf("application/json") !== -1) {
      return await response.json();
    } else {
      return await response.text();
    }
  } catch (error) {
    console.error(`Error pada ${method} ${endpoint}:`, error);
    throw error; // Lempar error agar bisa ditangkap oleh UI (try-catch di HTML)
  }
}

// Fungsi Logout
function logout() {
  localStorage.clear();
  window.location.href = "login.html";
}
