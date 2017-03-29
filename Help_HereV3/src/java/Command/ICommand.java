package Command;

import Command.*;
import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
    public String executar(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
