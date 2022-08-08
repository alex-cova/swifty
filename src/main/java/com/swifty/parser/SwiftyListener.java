// Generated from /Users/alex/Developer/Swifty/src/main/java/antlr/Swifty.g4 by ANTLR 4.10.1
package com.swifty.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SwiftyParser}.
 */
public interface SwiftyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(SwiftyParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(SwiftyParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(SwiftyParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(SwiftyParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(SwiftyParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(SwiftyParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(SwiftyParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(SwiftyParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(SwiftyParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(SwiftyParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(SwiftyParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(SwiftyParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(SwiftyParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(SwiftyParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void enterParametersList(SwiftyParser.ParametersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void exitParametersList(SwiftyParser.ParametersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(SwiftyParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(SwiftyParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SwiftyParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SwiftyParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#parameterWithDefaultValue}.
	 * @param ctx the parse tree
	 */
	void enterParameterWithDefaultValue(SwiftyParser.ParameterWithDefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#parameterWithDefaultValue}.
	 * @param ctx the parse tree
	 */
	void exitParameterWithDefaultValue(SwiftyParser.ParameterWithDefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SwiftyParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SwiftyParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(SwiftyParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(SwiftyParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(SwiftyParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(SwiftyParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SwiftyParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SwiftyParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SwiftyParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SwiftyParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(SwiftyParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(SwiftyParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SwiftyParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SwiftyParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(SwiftyParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(SwiftyParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link SwiftyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnWithValue(SwiftyParser.ReturnWithValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link SwiftyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnWithValue(SwiftyParser.ReturnWithValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link SwiftyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnVoid(SwiftyParser.ReturnVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link SwiftyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnVoid(SwiftyParser.ReturnVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SwiftyParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SwiftyParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(SwiftyParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(SwiftyParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#forConditions}.
	 * @param ctx the parse tree
	 */
	void enterForConditions(SwiftyParser.ForConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#forConditions}.
	 * @param ctx the parse tree
	 */
	void exitForConditions(SwiftyParser.ForConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(SwiftyParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(SwiftyParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnnamedArgumentsList}
	 * labeled alternative in {@link SwiftyParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterUnnamedArgumentsList(SwiftyParser.UnnamedArgumentsListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnnamedArgumentsList}
	 * labeled alternative in {@link SwiftyParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitUnnamedArgumentsList(SwiftyParser.UnnamedArgumentsListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NamedArgumentsList}
	 * labeled alternative in {@link SwiftyParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgumentsList(SwiftyParser.NamedArgumentsListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NamedArgumentsList}
	 * labeled alternative in {@link SwiftyParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgumentsList(SwiftyParser.NamedArgumentsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SwiftyParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SwiftyParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgument(SwiftyParser.NamedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgument(SwiftyParser.NamedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(SwiftyParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(SwiftyParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Substract}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubstract(SwiftyParser.SubstractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Substract}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubstract(SwiftyParser.SubstractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(SwiftyParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(SwiftyParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivide(SwiftyParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivide(SwiftyParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarReference(SwiftyParser.VarReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarReference(SwiftyParser.VarReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(SwiftyParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(SwiftyParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(SwiftyParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(SwiftyParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Supercall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSupercall(SwiftyParser.SupercallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Supercall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSupercall(SwiftyParser.SupercallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SwiftyParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SwiftyParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstructorCall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstructorCall(SwiftyParser.ConstructorCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstructorCall}
	 * labeled alternative in {@link SwiftyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstructorCall(SwiftyParser.ConstructorCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void enterVariableReference(SwiftyParser.VariableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void exitVariableReference(SwiftyParser.VariableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SwiftyParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SwiftyParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SwiftyParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(SwiftyParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SwiftyParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(SwiftyParser.QualifiedNameContext ctx);
}