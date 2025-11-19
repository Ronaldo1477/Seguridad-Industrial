// Objeto que almacena los usuarios y sus roles/credenciales
const USUARIOS_VALIDOS = {
    // Administradores
    "admin1": { password: "seguridad25", rol: "admin" },
    "jefe_sst": { password: "jefe2025", rol: "admin" },
    
    // Empleados
    "juan.p": { password: "juan123", rol: "empleado" },
    "ana.m": { password: "ana123", rol: "empleado" }
};

// Función de login mejorada que usa el backend
async function validarLogin() {
    const usuarioInput = document.getElementById('usuario').value.toLowerCase();
    const passwordInput = document.getElementById('password').value;
    const mensajeError = document.getElementById('mensaje-error');
    
    if (mensajeError) {
        mensajeError.textContent = '';
    }

    // 1. Primero intentar con el backend
    try {
        const response = await fetch('http://localhost:8081/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                usuario: usuarioInput,
                password: passwordInput
            })
        });
        
        const result = await response.json();
        
        if (result.success) {
            // Guardar información del usuario
            sessionStorage.setItem('usuario', result.usuario);
            sessionStorage.setItem('rol', result.rol);
            
            // Redirigir según el rol
            if (result.rol === 'admin') {
                window.location.href = 'admin_dashboard.html';
            } else {
                window.location.href = 'empleado_dashboard.html';
            }
            return; // Salir si el backend funcionó
        }
    } catch (error) {
        console.log('Backend no disponible, usando validación local');
    }
    
    // 2. Si el backend falla, usar validación local (fallback)
    const usuarioInfo = USUARIOS_VALIDOS[usuarioInput];

    if (!usuarioInfo) {
        if (mensajeError) {
            mensajeError.textContent = "Error: Usuario no encontrado.";
        }
        return;
    }

    if (usuarioInfo.password !== passwordInput) {
        if (mensajeError) {
            mensajeError.textContent = "Error: Contraseña incorrecta.";
        }
        return;
    }

    // Login exitoso con validación local
    sessionStorage.setItem('usuario', usuarioInput);
    sessionStorage.setItem('rol', usuarioInfo.rol);
    
    if (usuarioInfo.rol === 'admin') {
        window.location.href = 'admin_dashboard.html';
    } else {
        window.location.href = 'empleado_dashboard.html';
    }
}

// Mantener el event listener original
document.addEventListener('DOMContentLoaded', () => {
    const botonIngresar = document.getElementById('boton-ingresar');
    if (botonIngresar) {
        botonIngresar.addEventListener('click', validarLogin);
    }
});