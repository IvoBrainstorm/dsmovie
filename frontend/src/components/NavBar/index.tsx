import {ReactComponent as GithubIcon} from 'assets/img/github.svg';
import './style.css'

function NavBar(){
    return(
        <header>
            <nav className='container'>
                <div className='dsmovie-nav-contant'>
                    <h1>DsMovie</h1>
                    <a href="https://github.com/IvoBrainstorm">
                        <div className='dsmovie-contact-container'>
                        <GithubIcon/>
                        <p className='dsmovie-contact-link'>/IvoBrainstorm</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    )
}

export default NavBar;