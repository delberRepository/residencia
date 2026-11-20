import heroImage from '../assets/fachada.png'
import { useState } from 'react'

function HeroSection() {
  const [showReservationForm, setShowReservationForm] = useState(false)
  const [submitted, setSubmitted] = useState(false)

  function handleSubmit(event) {
    event.preventDefault()
    setSubmitted(true)
  }

  return (
    <section
      id="inicio"
      className="hero-section"
      style={{ backgroundImage: `linear-gradient(90deg, rgba(18, 32, 42, 0.60), rgba(18, 32, 42, 0.92)), url(${heroImage})` }}
    >
      <div className="hero-content">
        {showReservationForm ? (
          <div className="reservation-form-panel">
            <p className="eyebrow">Residencia universitaria</p>
            <h1>Solicitud de reserva</h1>
            {submitted ? (
              <p className="reservation-success" role="status">
                Gracias. Tu solicitud se ha validado en este formulario, pero todavía no se ha enviado a la residencia.
              </p>
            ) : (
              <form className="reservation-form" onSubmit={handleSubmit}>
                <label>
                  Nombre
                  <input name="nombre" autoComplete="given-name" required />
                </label>
                <label>
                  Apellidos
                  <input name="apellidos" autoComplete="family-name" required />
                </label>
                <label>
                  Fecha de nacimiento
                  <input name="fechaNacimiento" type="date" autoComplete="bday" required />
                </label>
                <label>
                  Estudios a realizar
                  <input name="estudios" required />
                </label>
                <label>
                  Fecha prevista de entrada
                  <input
                      name="fechaEntrada"
                      type="date"
                      min="2027-05-01"
                      required
                  />
                </label>
                <label>
                  Tipo de habitación
                  <select name="tipoHabitacion" className="form-input" required>
                    <option value="">Seleccionar</option>
                    <option value="normal">Basic</option>
                    <option value="premium">Premium</option>
                  </select>
                </label>

                <label>
                  Correo electrónico
                  <input name="correo" type="email" autoComplete="email" required />
                </label>
                <label>
                  Teléfono
                  <input name="telefono" type="tel" autoComplete="tel" required />
                </label>
                <label className="reservation-consent">
                  <input name="consentimiento" type="checkbox" required />
                  <span>Consiento la cesión de los datos personales a Domus Universia con fines informativos.</span>
                </label>
                <details className="privacy-details">
                  <summary>Responsable: Residencias de Estudiantes Domus Universia. Finalidad: informarte sobre nuestros servicios. Base: tu consentimiento. Cesión: si aceptas, podremos compartir tus datos con entidades del Grupo Domus Universia. Derechos: acceso, rectificación, supresión, portabilidad y otros.</summary>
                  <div className="privacy-full-text">
                    <p>Te informamos de que la Sociedad Residencias de Estudiantes S.L., con domicilio en Paseo de la Castellana, 163, 3º Iz. - 28046 Madrid (España), con C.I.F. número B-60109188, y correo electrónico <a href="mailto:privacy@resa.es">privacy@resa.es</a>, será el responsable de los datos que se recaban en este formulario.</p>
                    <p>Utilizaremos los datos personales con fines comerciales, lo cual incluye ponernos en contacto contigo para informarte sobre los detalles de productos, servicios y promociones que ofrecemos y que puedan ser de tu interés actualmente o en el futuro. Asimismo, si consientes mediante la casilla que aparece en el formulario, cederemos tus datos a otras entidades del Grupo Resa así como a otras entidades titulares de las residencias gestionadas por el Grupo Resa, para que te envíen información comercial. Puedes consultar el listado de entidades afiliadas en el siguiente enlace: <a href="https://www.resa.es/es/aviso-legal/" target="_blank" rel="noreferrer">aviso legal</a>.</p>
                    <p>La base legal para el tratamiento de tus datos es el consentimiento que nos otorgas al marcar las casillas que aparecen en el formulario, junto con tu acción de “Enviar”.</p>
                    <p>Por último, te informamos de que tienes derechos en relación con el tratamiento de los datos, incluido el derecho de portabilidad, acceso, rectificación, supresión o limitación de los datos y a retirar tu consentimiento en cualquier momento. Asimismo, te informamos sobre el derecho de presentar una reclamación ante una autoridad de protección de datos. Puedes ejercitar los derechos anteriormente mencionados, contactándonos a través de correo electrónico <a href="mailto:privacy@resa.es">privacy@resa.es</a>.</p>
                  </div>
                </details>
                <div className="reservation-form-actions">
                  <button className="secondary-button" type="button" onClick={() => { setShowReservationForm(false); setSubmitted(false) }}>
                    Volver
                  </button>
                  <button className="primary-button" type="submit">Enviar solicitud</button>
                </div>
              </form>
            )}
          </div>
        ) : (
          <>

        <p className="eyebrow">Residencia universitaria</p>
        <h1>Un lugar comodo para estudiar, convivir y sentirte en casa</h1>
        <p className="hero-copy">
          Habitaciones preparadas para el ritmo universitario, zonas comunes cuidadas y un equipo cercano para acompanar tu estancia.
        </p>
        <div className="hero-actions">
          <a className="secondary-button" href="#contacto">
            Solicitar informacion
          </a>
          <button className="primary-button" type="button" onClick={() => setShowReservationForm(true)}>
            Reserva ya tu plaza
          </button>
          { /*<a className="secondary-button" href="#servicios">
            Ver servicios
          </a>*/}

        </div>
          </>
        )}
      </div>
    </section>
  )
}

export default HeroSection
