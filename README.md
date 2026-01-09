# Motor de Priorización (Spring Boot + React)

Backend deploy: [[Link to Render](https://proteccion-prueba.onrender.com/)]
Frontend deploy: [[Link to Vercel](https://proteccion-prueba-front.vercel.app/)]

## Arquitectura
Solución Full-Stack desacoplada:
- **Backend:** Java 21, Spring Boot 3, Docker.
- **Frontend:** React, Vite, TailwindCSS.
- **Base de Datos:** H2 (In-Memory) para MVP.

## Estrategia de Priorización (Weighted Scoring)
La lógica de negocio se encuentra aislada en `PrioridadCalculator.java` para facilitar testeo y mantenibilidad.
- **Incidentes:** Base +1000 pts.
- **Requerimientos:** Base +500 pts.
- **Consultas:** Base +100 pts.
- **Aging:** +1 pto por hora de espera.
- **Manual:** Multiplicador x10 (rango: 1-5).

## Ejecución Local
1. `mvn spring-boot:run`
2. `cd frontend && npm run dev`
